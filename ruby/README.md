# Data Masking API - Ruby Gem

Data Masking redacts sensitive data like emails, phone numbers, payment cards, IP addresses, and dates using placeholder tokens. It returns the sanitized string and detection counts for each pattern found.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_datamasking'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_datamasking
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_datamasking'

# Initialize the client
client = APIVerve::Datamasking::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  text: "Contact John at john.doe@email.com or call 555-123-4567",
  types: ["email","phone","ssn","credit_card","ip_address","url","date"]
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ text: "Contact John Doe at john.doe@email.com or call 555-123-4567. His SSN is 123-45-6789." })
  puts response["data"]
rescue APIVerve::Datamasking::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Datamasking::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Datamasking::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/datamasking?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/datamasking?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/datamasking?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
