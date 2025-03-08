import { INestApplication, Module } from '@nestjs/common';
import { DocumentBuilder, OpenAPIObject, SwaggerCustomOptions, SwaggerModule } from '@nestjs/swagger';
import { SecuritySchemeObject } from '@nestjs/swagger/dist/interfaces/open-api-spec.interface';

@Module({})
export class OpenAPIModule {

  public static configure(app: INestApplication) {

    const document = SwaggerModule.createDocument(app, this.getDocument());
    SwaggerModule.setup('api/doc/ui', app, document, this.getOptions());
  }

  public static getDocument(): Omit<OpenAPIObject, 'paths'> {
    return new DocumentBuilder()
      .setTitle('APP - BOOKS')
      .setVersion('1.0')
      .setDescription('APP - BOOKS')
      .addBearerAuth(this.getSecurityOptions(), 'bearerAuth')
      .build();


  }

  public static getSecurityOptions(): SecuritySchemeObject {
    return { type: 'http', scheme: 'bearer', bearerFormat: 'Bearer' };
  }

  public static getOptions(): SwaggerCustomOptions {
    return {
      swaggerUrl: '/api/doc/ui',
      jsonDocumentUrl: '/api/doc/json',
      yamlDocumentUrl: '/api/doc/yaml',
      swaggerUiEnabled: true,
      swaggerOptions: {
        servers: [
          {
            url: '/',
          },
        ],
      },
    };

  }



}
