/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,js}",
    "../src/main/resources/templates/**/*.html"
  ],
  theme: {
    extend: {
      colors: {
        // Primary - Main actions, links, highlights
        primary: {
          DEFAULT: '#0A84FF',
          hover: '#2A9AFF',
          active: '#0070D4',
          light: 'rgba(10, 132, 255, 0.1)',
          dark: '#005BB5',
        },
        // Secondary - Secondary elements, borders
        secondary: {
          DEFAULT: '#1D1D1D',
          hover: '#2D2D2D',
          active: '#151515',
          light: '#2A2A2A',
        },
        // Accent - Warnings, highlights, CTAs
        accent: {
          DEFAULT: '#FFD60A',
          hover: '#FFE84D',
          active: '#E6C209',
          light: 'rgba(255, 214, 10, 0.1)',
        },
        // Background - Main app background
        background: {
          DEFAULT: '#0F0F0F',
          overlay: 'rgba(15, 15, 15, 0.9)',
        },
        // Surface - Cards, panels, elevated surfaces
        surface: {
          DEFAULT: '#1F1F1F',
          hover: '#2A2A2A',
          elevated: '#2F2F2F',
        },
        // Text - Primary text content
        text: {
          DEFAULT: '#FFFFFF',
          primary: '#FFFFFF',
          secondary: 'rgba(255, 255, 255, 0.8)',
          tertiary: 'rgba(255, 255, 255, 0.6)',
          disabled: 'rgba(255, 255, 255, 0.4)',
          onAccent: '#0F0F0F',
        },
        // Status colors
        success: '#34C759',
        warning: '#FFD60A',
        error: '#FF3B30',
        info: '#0A84FF',
      },
      backgroundColor: {
        'app-bg': '#0F0F0F',
        'card': '#1F1F1F',
      },
      textColor: {
        'primary': '#FFFFFF',
        'secondary': 'rgba(255, 255, 255, 0.8)',
        'tertiary': 'rgba(255, 255, 255, 0.6)',
      },
      borderColor: {
        'default': '#1D1D1D',
        'focus': '#0A84FF',
      },
      boxShadow: {
        'primary': '0 4px 12px rgba(10, 132, 255, 0.1)',
        'card': '0 2px 8px rgba(0, 0, 0, 0.2)',
      },
    },
  },
  plugins: [],
}

