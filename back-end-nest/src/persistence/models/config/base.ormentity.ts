import { ApiProperty } from '@nestjs/swagger';
import {
  PrimaryGeneratedColumn,
  CreateDateColumn,
  UpdateDateColumn,
  VersionColumn,
  BaseEntity as TypeORMBaseEntity
} from 'typeorm';

export abstract class BaseEntity extends TypeORMBaseEntity {

  @ApiProperty()
  @PrimaryGeneratedColumn()
  id: number;

  @ApiProperty()
  @CreateDateColumn({ type: 'timestamp', update: false })
  createdDate: Date;

  @ApiProperty()
  @UpdateDateColumn({ type: 'timestamp' })
  lastModifiedDate: Date;

  @ApiProperty()
  @VersionColumn()
  version: number;
}
