
@RestController
@RequestMapping(value="/clientes")
public class CadastroController {
    
    @Autowired
    CadastroClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente) {
        clienteService.inserirCliente();
        
        URI location = uriBuilder.path("clientes/{numeroCnh}").buildAndExpand(cliente.getNumeroCnh()).toUri();        
        return ResponseEntity.created(location).body(cliente);       
    }

    @GetMapping("/{numeroCnh}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable long numeroCnh) {
        return ResponseEntity.ok().body(clienteService.encontrarCliente(numeroCnh))
    }





}