# Cierre de Empalme FTTH — PWA

Herramienta mobile-first para documentación técnica de cajas de empalme de fibra óptica.

## Estructura del proyecto

```
cierre-empalme/
├── public/
│   ├── index.html     ← App completa (single file)
│   ├── manifest.json  ← PWA manifest
│   ├── sw.js          ← Service worker (cache offline)
│   ├── icon-192.png   ← Ícono (generar antes de deploy)
│   └── icon-512.png   ← Ícono grande
└── vercel.json        ← Config de deploy
```

## Deploy en Vercel

```bash
# 1. Subir a GitHub (BitShitLynx org)
git init
git add .
git commit -m "feat: PWA cierre empalme FTTH v1"
git remote add origin https://github.com/BitShitLynx/cierre-empalme
git push -u origin main

# 2. En vercel.com → New Project → importar repo
# Root directory: (dejar vacío o poner /)
# Output directory: public
# Framework: Other
```

## Íconos (generar antes de deploy)

Necesitás dos PNGs con el logo de la app:
- `public/icon-192.png` (192×192px)
- `public/icon-512.png` (512×512px)

Podés generarlos en https://realfavicongenerator.net o con cualquier editor.

## Instalar en Android (sin APK)

1. Abrir la URL en Chrome
2. Menú → "Añadir a pantalla de inicio" (o banner automático)
3. La app queda instalada, funciona offline

## Fase 2 — APK con Capacitor

```bash
npm init @capacitor/app
npx cap add android
# Copiar contenido de public/ a www/
npx cap sync
npx cap open android
# En Android Studio: Build → Generate Signed APK
```

## Features actuales (v1)

- Configuración de la caja (nombre, ubicación, modelo, capacidad)
- Gestión de cables por puerto (entrada/salida, fibras, color)
- Vista frontal SVG del cierre con puertos distribuidos
- Tabla de fusiones con código de colores ITU-T
- Exportar JSON y SVG
- Funciona offline (service worker)
- Instalable como PWA

## Roadmap

- [ ] Múltiples cajas (localStorage o IndexedDB)
- [ ] Buffers de color para cables multifibra (24F = 2×12)
- [ ] Vista lateral con dimensiones
- [ ] Export PDF (diagrama + tabla fusiones en una página)
- [ ] QR code por caja para acceso rápido en campo
