/**
 * APP - BOOKS
 *
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { SortObject } from './sortObject';


export interface PageableObject { 
    offset?: number;
    sort?: SortObject;
    paged?: boolean;
    unpaged?: boolean;
    pageSize?: number;
    pageNumber?: number;
}

