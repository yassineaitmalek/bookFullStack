import { ApiProperty } from '@nestjs/swagger';
import { IsString, IsNotEmpty, IsNumber, } from 'class-validator';

export class BookDTO {



  @IsString()
  @IsNotEmpty()
  @ApiProperty()
  author: string;

  @IsString()
  @IsNotEmpty()
  @ApiProperty()
  country: string;

  @IsString()
  @IsNotEmpty()
  @ApiProperty()
  language: string;

  @IsNumber()
  @IsNotEmpty()
  @ApiProperty()
  pages: number;

  @IsString()
  @IsNotEmpty()
  @ApiProperty()
  title: string;

  @IsNumber()
  @IsNotEmpty()
  @ApiProperty()
  year: number;

}