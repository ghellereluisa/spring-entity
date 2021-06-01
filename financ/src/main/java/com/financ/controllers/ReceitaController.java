@RestController
@RequestMapping ("receitas")

public class ReceitaController {
    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> list(){
        return ResponseEntity.ok(receitaService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Receita> findById(@PathVariable Long id){
        return ResponseEntity.ok(receitaService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Receita> save(@RequestBody @Valid Receita receita){
        return new ResponseEntity<>(receitaService.save(receita), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        receitaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody Receita receita){
        receitaService.replace(receita);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}