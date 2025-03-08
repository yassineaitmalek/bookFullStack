import { Column, Entity } from "typeorm";
import { BaseEntity } from "../config/base.ormentity";
import { ApiProperty } from "@nestjs/swagger";

@Entity('books')
export class BookEntity extends BaseEntity {

  @ApiProperty()
  @Column({ type: 'varchar', length: 255, nullable: false })
  author: string;

  @ApiProperty()
  @Column({ type: 'varchar', length: 255, nullable: false })
  country: string;

  @ApiProperty()
  @Column({ type: 'varchar', length: 255, nullable: false })
  language: string;

  @ApiProperty()
  @Column({ type: 'integer', nullable: false })
  pages: number;

  @ApiProperty()
  @Column({ type: 'varchar', length: 255, nullable: false })
  title: string;

  @ApiProperty()
  @Column({ type: 'integer', nullable: false })
  year: number;

}