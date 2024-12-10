/**
 * APP - BOOKS
 *
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { Cover } from './cover';
import { Content } from './content';


export interface Book { 
    id?: number;
    createdDate?: string;
    lastModifiedDate?: string;
    version?: number;
    author?: string;
    country?: string;
    language?: string;
    pages?: number;
    title?: string;
    year?: number;
    cover?: Cover;
    content?: Content;
}
