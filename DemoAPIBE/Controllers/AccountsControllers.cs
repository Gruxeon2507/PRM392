using DemoAPIBE.DTO;
using DemoAPIBE.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace DemoAPIBE.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AccountsController : ControllerBase
    {
        private readonly PRM392_DemoApiDBContext _context;

        public AccountsController(PRM392_DemoApiDBContext context)
        {
            _context = context;
        }

        // GET: api/Accounts
        [HttpGet]
        public  IActionResult GetAccounts()
        {
            var accounts = _context.Accounts
                .AsNoTracking()
                .Select(account => new AccountDto
                {
                    Id = account.Id,
                    Name = account.Name,
                    Pass = account.Password,
                    Detail = account.Detail
                })
                .ToList();
            return Ok(accounts);
        }

        // GET: api/Accounts/5
        [HttpGet("{id}")]
        public async Task<ActionResult<AccountDto>> GetAccount(int id)
        {
            var account = await _context.Accounts.FindAsync(id);

            if (account == null)
            {
                return NotFound();
            }

            var accountDto = new AccountDto
            {
                Id = account.Id,
                Name = account.Name,
                Pass = account.Password,
                Detail = account.Detail
            };

            return accountDto;
        }

        // PUT: api/Accounts/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutAccount(int id, Account account)
        {
            if (id != account.Id)
            {
                return BadRequest();
            }

            _context.Entry(account).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AccountExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Accounts
        [HttpPost]
        public async Task<ActionResult<AccountDto>> PostAccount(Account account)
        {
            _context.Accounts.Add(account);
            await _context.SaveChangesAsync();

            var accountDto = new AccountDto
            {
                Id = account.Id,
                Name = account.Name,
                Pass = account.Password,
                Detail = account.Detail
            };

            return CreatedAtAction(nameof(GetAccount), new { id = account.Id }, accountDto);
        }

        // DELETE: api/Accounts/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteAccount(int id)
        {
            var account = await _context.Accounts.FindAsync(id);
            if (account == null)
            {
                return NotFound();
            }

            _context.Accounts.Remove(account);
            await _context.SaveChangesAsync();

            var accountDto = new AccountDto
            {
                Id = account.Id,
                Name = account.Name,
                Pass = account.Password,
                Detail = account.Detail
            };

            return Ok(accountDto);
        }

        private bool AccountExists(int id)
        {
            return _context.Accounts.Any(e => e.Id == id);
        }
    }
}
