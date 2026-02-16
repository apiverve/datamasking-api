/// Response models for the Data Masking API.

/// API Response wrapper.
class DatamaskingResponse {
  final String status;
  final dynamic error;
  final DatamaskingData? data;

  DatamaskingResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DatamaskingResponse.fromJson(Map<String, dynamic> json) => DatamaskingResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DatamaskingData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Data Masking API.

class DatamaskingData {
  String? masked;
  DatamaskingDataDetected? detected;

  DatamaskingData({
    this.masked,
    this.detected,
  });

  factory DatamaskingData.fromJson(Map<String, dynamic> json) => DatamaskingData(
      masked: json['masked'],
      detected: json['detected'] != null ? DatamaskingDataDetected.fromJson(json['detected']) : null,
    );
}

class DatamaskingDataDetected {
  int? email;
  int? phone;
  int? ssn;
  int? creditCard;
  int? ipAddress;
  int? url;
  int? date;

  DatamaskingDataDetected({
    this.email,
    this.phone,
    this.ssn,
    this.creditCard,
    this.ipAddress,
    this.url,
    this.date,
  });

  factory DatamaskingDataDetected.fromJson(Map<String, dynamic> json) => DatamaskingDataDetected(
      email: json['email'],
      phone: json['phone'],
      ssn: json['ssn'],
      creditCard: json['credit_card'],
      ipAddress: json['ip_address'],
      url: json['url'],
      date: json['date'],
    );
}

class DatamaskingRequest {
  String text;

  DatamaskingRequest({
    required this.text,
  });

  Map<String, dynamic> toJson() => {
      'text': text,
    };
}
