import vue from '@vitejs/plugin-vue'
import { nodePolyfills } from 'vite-plugin-node-polyfills'

import createAutoImport from './auto-import'
import createSvgIcon from './svg-icon'
import createCompression from './compression'
import createSetupExtend from './setup-extend'

export default function createVitePlugins(viteEnv, isBuild = false) {
    const vitePlugins = [
        vue(),

        // 👇 注入 global 垫片（仅开发环境需要，但放这里无害）
        nodePolyfills({
            include: ['global'], // 只 polyfill global，减少体积
            globals: {
                global: true,
                // 如果后续还有 process、Buffer 等问题，可一并开启
                // process: true,
                // buffer: true
            }
        })
    ]
    vitePlugins.push(createAutoImport())
    vitePlugins.push(createSetupExtend())
    vitePlugins.push(createSvgIcon(isBuild))
    isBuild && vitePlugins.push(...createCompression(viteEnv))
    return vitePlugins
}
