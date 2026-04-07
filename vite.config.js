import { defineConfig } from 'vite';
import laravel from 'laravel-vite-plugin';

export default defineConfig({
    server: {
        host: '0.0.0.0',          // Permite conexiones desde cualquier IP
        port: 5173,
        strictPort: true,
        hmr: {
            host: 'educazempic.local', // Hot Module Replacement apunta al dominio
        },
        cors: true,                // ¡Importante! Permite solicitudes desde tu navegador
    },
    plugins: [
        laravel({
            input: ['resources/js/app.jsx'],
            refresh: true,
        }),
    ],
});