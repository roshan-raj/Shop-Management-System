// Swagger set up
let options = {
    swaggerDefinition: {
        openapi: "3.0.0",
        info: {
            title: "Shop Management System API",
            version: "1.0.0",
            description:
                "Documentation of the REST API created for Shop Management System - Backend",
        },
        components: {
            securitySchemes: {
                bearerAuth: {
                    type: "http",
                    scheme: "bearer",
                    bearerFormat: "JWT",
                }
            }
        },
        security: {
            bearerAuth: []
        },
        servers: [
            {
                url: `/`
            }
        ]
    },
    apis: [
        "./routes/authRoutes.js"
    ]
};

module.exports = {
    options
};
