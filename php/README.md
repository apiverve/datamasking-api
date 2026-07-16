# Data Masking API - PHP Package

Data Masking is a powerful tool for detecting and masking sensitive information in text. It can identify and redact emails, phone numbers, SSNs, credit cards, IP addresses, URLs, and dates.

## Installation

Install via Composer:

```bash
composer require apiverve/datamasking
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Datamasking\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'text' => 'Contact John at john.doe@email.com or call 555-123-4567',
    'types' => ["email","phone","ssn","credit_card","ip_address","url","date"]
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Datamasking\Client;
use APIVerve\Datamasking\Exceptions\APIException;
use APIVerve\Datamasking\Exceptions\ValidationException;

try {
    $response = $client->execute(['text' => 'Contact John Doe at john.doe@email.com or call 555-123-4567. His SSN is 123-45-6789.']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/datamasking?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/datamasking?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/datamasking?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
