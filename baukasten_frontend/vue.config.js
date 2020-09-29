var webpack = require("webpack");

module.exports = {
  transpileDependencies: ["vuetify"],
  devServer: {
    proxy: {
      pois: {
        target: "http://localhost:8085/",
        changeOrigin: true,
        secure: false
      },
      projects: {
        target: "http://localhost:8085/",
        changeOrigin: true,
        secure: false
      }
    }
  },
  configureWebpack: {
    plugins: [
      new webpack.ProvidePlugin({
        "window.Quill": "quill/dist/quill.js",
        Quill: "quill/dist/quill.js"
      })
    ]
  }
};
