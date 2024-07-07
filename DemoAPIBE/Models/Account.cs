using System;
using System.Collections.Generic;

namespace DemoAPIBE.Models
{
    public partial class Account
    {
        public int Id { get; set; }
        public string? Name { get; set; }
        public string? Password { get; set; }
        public string? Detail { get; set; }
    }
}
