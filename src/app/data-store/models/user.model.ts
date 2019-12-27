export class User {

  userId: number = null;
  name: string = null;
  emailId: string;
  password: string;
  gender: string = null;
  statusCode: number = null;
  role: Role[];
}

export class Role {
  roleId: number = null;
  roleName: string = null;
}
