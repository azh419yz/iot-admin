<template>
  <div class="app-container">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>WebSocket Real-time Test</span>
        <el-tag :type="connected ? 'success' : 'danger'" style="margin-left: 10px">
          {{ connected ? 'Connected' : 'Disconnected' }}
        </el-tag>
      </div>
      
      <el-row :gutter="20">
        <el-col :span="12">
          <h3>Send Data</h3>
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="Content">
              <el-input type="textarea" v-model="form.content" :rows="4" placeholder="Enter JSON data..."></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="sendData" :loading="loading">Send Push</el-button>
              <el-button @click="connect" v-if="!connected">Connect</el-button>
              <el-button type="danger" @click="disconnect" v-else>Disconnect</el-button>
            </el-form-item>
          </el-form>
        </el-col>
        
        <el-col :span="12">
          <h3>Received Messages</h3>
          <div class="message-box">
            <div v-for="(msg, index) in messages" :key="index" class="message-item">
              <span class="time">[{{ msg.time }}]</span>
              <span class="content">{{ msg.content }}</span>
            </div>
            <div v-if="messages.length === 0" class="no-data">No messages received yet</div>
          </div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'
import request from '@/utils/request'

export default {
  name: 'WebSocketTest',
  data() {
    return {
      connected: false,
      stompClient: null,
      loading: false,
      form: {
        content: '{"message": "Hello WebSocket", "value": ' + Math.floor(Math.random() * 100) + '}'
      },
      messages: []
    }
  },
  mounted() {
    this.connect()
  },
  beforeDestroy() {
    this.disconnect()
  },
  methods: {
    connect() {
      if (this.connected) return
      
      // 通过后端代理前缀连接，避免直连地址不一致
      const socket = new SockJS((import.meta.env.VITE_APP_BASE_API || '/dev-api') + '/ws')
      this.stompClient = Stomp.over(socket)
      
      // Disable debug logs
      this.stompClient.debug = null
      
      this.stompClient.connect({}, (frame) => {
        this.connected = true
        this.$message.success('WebSocket Connected')
        console.log('Connected: ' + frame)
        
        // Subscribe to /topic/data
        this.stompClient.subscribe('/topic/data', (response) => {
          this.handleMessage(response.body)
        })
      }, (error) => {
        console.error('WebSocket Error:', error)
        this.connected = false
        this.$message.error('WebSocket Connection Failed')
      })
    },
    
    disconnect() {
      if (this.stompClient !== null && this.connected) {
        this.stompClient.disconnect()
      }
      this.connected = false
      console.log("Disconnected")
    },
    
    handleMessage(message) {
      const now = new Date()
      const timeStr = `${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`
      
      this.messages.unshift({
        time: timeStr,
        content: message
      })
      
      // Keep only last 20 messages
      if (this.messages.length > 20) {
        this.messages.pop()
      }
    },
    
    sendData() {
      if (!this.form.content) {
        this.$message.warning('Please enter content')
        return
      }
      
      try {
        const data = JSON.parse(this.form.content)
        this.loading = true
        
        // Call the backend API to trigger the push
        request({
          url: '/custom/push',
          method: 'post',
          data: data
        }).then(response => {
          this.$message.success('Push triggered successfully')
          this.loading = false
        }).catch(error => {
          console.error(error)
          this.loading = false
        })
        
      } catch (e) {
        this.$message.error('Invalid JSON format')
      }
    }
  }
}
</script>

<style scoped>
.message-box {
  border: 1px solid #dcdfe6;
  border-radius: 4px;
  padding: 10px;
  height: 400px;
  overflow-y: auto;
  background-color: #f5f7fa;
}

.message-item {
  padding: 5px 0;
  border-bottom: 1px dashed #e4e7ed;
  font-family: monospace;
}

.time {
  color: #909399;
  margin-right: 10px;
}

.content {
  color: #606266;
  word-break: break-all;
}

.no-data {
  text-align: center;
  color: #909399;
  margin-top: 20px;
}
</style>
