import { Column } from "typeorm";
import { BaseEntity } from "../config/base.ormentity";

export class Attachement extends BaseEntity {

  @Column({ type: 'varchar', length: 255, nullable: false })
  ext: string;

  @Column({ type: 'varchar', length: 255, nullable: false })
  extension: string;

  @Column({ type: 'varchar', length: 255, nullable: false })
  originalFileName: string;

  @Column({ type: 'varchar', length: 255, nullable: false })
  path: string;

  @Column({ type: 'integer', nullable: false })
  fileSize: number;

  @Column({ type: 'varchar', length: 255, nullable: false })
  fileType: string;
}