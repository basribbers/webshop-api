    package com.bas.webshop_api.adapter;

    import com.bas.webshop_api.data.ProductDto;
    import com.bas.webshop_api.exeption.ExternalApiException;
    import com.bas.webshop_api.mapper.ProductDtoMapper;
    import com.bas.webshop_api.ports.ProductPort;
    import com.bas.webshop_api.response.ProductResponse;
    import org.springframework.stereotype.Component;
    import tools.jackson.core.type.TypeReference;
    import tools.jackson.databind.DeserializationFeature;
    import tools.jackson.databind.ObjectMapper;

    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.List;

    @Component
    public class ProductAdapter implements ProductPort {

        private final ObjectMapper objectMapper = new ObjectMapper();
        private final  HttpClient client;
        private final  String url;


        public ProductAdapter(HttpClient client, String url) {
            this.client = client;
            this.url = url;
        }

        private HttpRequest getRequest(String uri) {
            return HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(uri))
                    .headers("Accept", "application/json")
                    .build();
        }
        public List<ProductResponse> getResponse()  {
           try {
               HttpResponse<String> response = client.send(getRequest(this.url), HttpResponse.BodyHandlers.ofString());
               return objectMapper.readValue(response.body(), new TypeReference<List<ProductResponse>>() {
               });
           }
            catch (IOException e) {
                  throw new ExternalApiException("Exception calling webshop api", e.getCause());
            }
            catch (InterruptedException e){
                    throw new ExternalApiException("Exception calling webshop api", e);
                }
            }


        //private String createUri(String pathParam){
         //   url = url.replace(":ticker:", pathParam);
          //  String uri = url;
          //  return uri;
       // }
        }
