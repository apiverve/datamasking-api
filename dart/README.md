# Data Masking API - Dart/Flutter Client

Data Masking is a powerful tool for detecting and masking sensitive information in text. It can identify and redact emails, phone numbers, SSNs, credit cards, IP addresses, URLs, and dates.

[![pub package](https://img.shields.io/pub/v/apiverve_datamasking.svg)](https://pub.dev/packages/apiverve_datamasking)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Data Masking API](https://apiverve.com/marketplace/datamasking?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_datamasking: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_datamasking/apiverve_datamasking.dart';

void main() async {
  final client = DatamaskingClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'text': 'Contact John Doe at john.doe@email.com or call 555-123-4567. His SSN is 123-45-6789.'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "masked": "Contact John Doe at [EMAIL] or call [PHONE]. His SSN is [SSN].",
    "detected": {
      "email": 1,
      "phone": 1,
      "ssn": 1,
      "credit_card": 0,
      "ip_address": 0,
      "url": 0,
      "date": 0
    }
  }
}
```

## API Reference

- **API Home:** [Data Masking API](https://apiverve.com/marketplace/datamasking?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/datamasking](https://docs.apiverve.com/ref/datamasking?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
