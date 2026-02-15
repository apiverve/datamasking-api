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
        /// Array of data types to mask (default: all types)
        /// </summary>
        [JsonProperty("types")]
        public string Types { get; set; }
    }
}
