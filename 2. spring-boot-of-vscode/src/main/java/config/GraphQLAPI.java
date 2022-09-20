package config;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import service.userDataFetcher;

@Component
public class GraphQLAPI {
    
    @Autowired userDataFetcher dataFetcher; 
    
    private GraphQL graphQL;

    // GraphQL ¼±¾ð
    @Value("classpath:static/graphql/user.graphqls")
    Resource resource;

      // (3)
    @Bean 
    public GraphQL graphQL() {
        return graphQL;
    }

    // (1)
    @PostConstruct
    public void init() throws IOException {
        URL url = resource.getURL();
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    // (2)
    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
        .type(
        TypeRuntimeWiring
        .newTypeWiring("Query")
        .dataFetcher("allUsers", dataFetcher.allUser())
        .dataFetcher("findUser", dataFetcher.findUser())      
        )
        .build();
    }

}
