using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DataMasking
{
    /// <summary>
    /// Query options for the Data Masking API
    /// </summary>
    public class DataMaskingQueryOptions
    {
        /// <summary>
        /// The text containing sensitive data to mask
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Array of data types to mask (default: all types). Allowed values: email, phone, ssn, credit_card, ip_address (IPv4 and IPv6), url, date; any other value returns a 400
        /// </summary>
        [JsonProperty("types")]
        public List<string>? Types { get; set; }
    }
}
