@Service
public class ReceitaService {

    public ReceitaService(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }

    public List<Receita> listAll(){
        return receitaRepository.findAll();
    }

    public Receita findByIdOrThrowBadRequestException(Long id){
        return receitaRepository.findById(id).orElseThrow(() -> new BadRequestException("Income Not Found!"));
    }

    @Transactional
    public Receita save(Receita receita){
        return receitaRepository.save(ReceitaMapper.INSTANCE.toReceita(receita));
    }

    public void delete(Long id){
        receitaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void edit(Receita receita){
        Receita savedReceita = findByIdOrThrowBadRequestException(receita.getId());
        Receita receita1 = ReceitaMapper.INSTANCE.toReceita(receita);
        receita1.setId(savedReceita.getId());
        receitaRepository.save(receita1);
    }
}