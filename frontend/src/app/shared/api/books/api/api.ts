export * from './attachementController.service';
import { AttachementControllerService } from './attachementController.service';
export * from './bookController.service';
import { BookControllerService } from './bookController.service';
export const APIS = [AttachementControllerService, BookControllerService];
