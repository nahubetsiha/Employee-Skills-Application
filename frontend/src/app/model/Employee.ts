import {Address} from './Address';
import {Role} from './Role';
import {BusinessUnit} from './BusinessUnit';
import {Skill} from './Skill';

export class Employee {
  id: string;
  firstName: string;
  lastName: string;
  address: Address;
  email: string;
  companyEmail: string;
  birthDate: string;
  hireDate: string;
  role: Role;
  businessUnit: BusinessUnit;
  skills: Skill[];
}
