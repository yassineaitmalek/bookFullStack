import { Module } from '@nestjs/common';
import { APP_FILTER } from '@nestjs/core';
import { GlobalExceptionFilter } from './presentation/exception';
import { PresentationModule } from './presentation/presentation.module';
import { PersistenceModule } from './persistence/persistence.module';
import { InfrastructureModule } from './infrastructure/infrastructure.module';


@Module({
  imports: [PresentationModule, PersistenceModule, InfrastructureModule,],
  controllers: [],
  providers: [

    {
      provide: APP_FILTER,
      useClass: GlobalExceptionFilter,
    },
  ],
})
export class AppModule { }
