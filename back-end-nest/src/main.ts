import { ValidationPipe } from "@nestjs/common";
import { NestFactory } from "@nestjs/core";
import { AppModule } from "./app.module";
import { OpenAPIModule } from "./infrastructure/config/open.api.module";
import { DataBaseConfig } from "./persistence/config/database.providers";

async function bootstrap() {

  await DataBaseConfig.createDatabaseIfNotExists();
  const app = await NestFactory.create(AppModule);
  OpenAPIModule.configure(app);
  app.useGlobalPipes(new ValidationPipe({ whitelist: true }));
  await app.listen(process.env.PORT ?? 8080);
}
bootstrap();
