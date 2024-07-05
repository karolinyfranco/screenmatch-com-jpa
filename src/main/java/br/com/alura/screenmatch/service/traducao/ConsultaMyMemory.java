package br.com.alura.screenmatch.service.traducao;

import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.net.URLEncoder;

public class ConsultaMyMemory {
    public static String obterTraducao(String text) {
        ConverteDados conversor = new ConverteDados();
        ConsumoApi consumo = new ConsumoApi();

        String texto = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");

        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        String json = consumo.obterDados(url);
        DadosTraducao traducao = conversor.obterDados(json, DadosTraducao.class);
        return traducao.dadosResposta().textoTraduzido();
    }
}
