/**
 * Basic Example - Data Masking API
 *
 * This example demonstrates how to use the Data Masking API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const datamaskingAPI = require('../index.js');

// Initialize the API client
const api = new datamaskingAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "text": "Contact John Doe at john.doe@email.com or call 555-123-4567. His SSN is 123-45-6789."
};

// Make the API request using callback
console.log('Making request to Data Masking API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
