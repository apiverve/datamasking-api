declare module '@apiverve/datamasking' {
  export interface datamaskingOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface datamaskingResponse {
    status: string;
    error: string | null;
    data: DataMaskingData;
    code?: number;
  }


  interface DataMaskingData {
      masked:   string;
      detected: Detected;
  }
  
  interface Detected {
      email:      number;
      phone:      number;
      ssn:        number;
      creditCard: number;
      ipAddress:  number;
      url:        number;
      date:       number;
  }

  export default class datamaskingWrapper {
    constructor(options: datamaskingOptions);

    execute(callback: (error: any, data: datamaskingResponse | null) => void): Promise<datamaskingResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: datamaskingResponse | null) => void): Promise<datamaskingResponse>;
    execute(query?: Record<string, any>): Promise<datamaskingResponse>;
  }
}
