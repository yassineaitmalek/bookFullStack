
import { TypeOrmModule } from '@nestjs/typeorm';
import { BookEntity } from '../models/local/book.entity';
import * as mysql from 'mysql2/promise';

export class DataBaseConfig {

  static async createDatabaseIfNotExists() {
    const connection = await mysql.createConnection({
      host: 'localhost',
      port: 3306,
      user: 'root',
      password: 'rootroot',
    });

    const databaseName = 'books';

    // Check if the database exists and create it if not
    await connection.query(`CREATE DATABASE IF NOT EXISTS \`${databaseName}\``);
    console.log(`Database "${databaseName}" is ready.`);
    await connection.end();
  }

  static getDatabaseConfig() {
    return TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: 'rootroot',
      database: 'books',
      entities: [BookEntity],
      synchronize: true,
      logging: true,
      // extra: {
      //   authPlugins: {
      //     mysql_native_password: true,
      //   },
      // },
    })


  }
}