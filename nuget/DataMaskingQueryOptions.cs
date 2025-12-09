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
        /// Example: Contact John at john.doe@email.com or call 555-123-4567
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Array of data types to mask (default: all types)
        /// Example: ["email","phone","ssn","credit_card","ip_address","url","date"]
        /// </summary>
        [JsonProperty("types")]
        public string Types { get; set; }
    }
}
