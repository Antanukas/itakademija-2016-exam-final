module.exports = {
    entry: "./src/index.js",
    output: {
        path: __dirname,
        filename: "bundle.js"
    },
    resolve: {
        extensions: ['.js', '.jsx','.css']
    },
    module: {
        loaders: [
            {test: /\.(js|jsx)$/, exclude: /node_modules/, loader: "babel-loader"},
            {test: /\.svg$/, loader: "svg-inline-loader"},
            {test: /\.css$/, loader: "style-loader!css-loader" }
        ]
    }
};