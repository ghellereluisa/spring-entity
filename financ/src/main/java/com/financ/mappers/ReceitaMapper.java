 @Mapper(componentModel = "spring")

 public abstract class ReceitaMapper{
     public static final ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);

     public abstract Receita toReceita(Receita receita);
 }