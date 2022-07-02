/** @type {import('tailwindcss').Config} */
module.exports = {
  mode: process.env.NODE_ENV ? "jit" : undefined,
  content: ["./src/**/*.{html,js}"],
  darkMode: false,
  theme: {
    extend: {},
  },
  variants: {
    extend: {}
  },
  plugins: [],
}
