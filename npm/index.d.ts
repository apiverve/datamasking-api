declare module '@apiverve/datamasking' {
  export interface datamaskingOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface datamaskingResponse {
    status: string;
    error: string | null;
    data: DataMaskingData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DataMaskingData {
      masked:   null | string;
      detected: Detected;
  }
  
  interface Detected {
      email:      number | null;
      phone:      number | null;
      ssn:        number | null;
      creditCard: number | null;
      ipAddress:  number | null;
      url:        number | null;
      date:       number | null;
  }

  export default class datamaskingWrapper {
    constructor(options: datamaskingOptions);

    execute(callback: (error: any, data: datamaskingResponse | null) => void): Promise<datamaskingResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: datamaskingResponse | null) => void): Promise<datamaskingResponse>;
    execute(query?: Record<string, any>): Promise<datamaskingResponse>;
  }
}
