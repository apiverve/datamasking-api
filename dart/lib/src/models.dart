/// Response models for the Data Masking API.

/// API Response wrapper.
class DatamaskingResponse {
  final String status;
  final dynamic error;
  final DatamaskingData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  DatamaskingResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory DatamaskingResponse.fromJson(Map<String, dynamic> json) => DatamaskingResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DatamaskingData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
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
  num? email;
  num? phone;
  num? ssn;
  num? creditCard;
  num? ipAddress;
  num? url;
  num? date;

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
