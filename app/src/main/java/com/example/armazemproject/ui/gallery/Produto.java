import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private String categoria;

    // Construtor
    public Produto(String codigo, String nome, String descricao, double precoUnitario, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

    // Getters e Setters
    // ...
}

public class MainActivity extends AppCompatActivity {
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtos = new ArrayList<>();

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = ((EditText) findViewById(R.id.editTextCodigo)).getText().toString();
                String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
                String descricao = ((EditText) findViewById(R.id.editTextDescricao)).getText().toString();
                double precoUnitario = Double.parseDouble(((EditText) findViewById(R.id.editTextPrecoUnitario)).getText().toString());
                String categoria = ((EditText) findViewById(R.id.editTextCategoria)).getText().toString();

                Produto produto = new Produto(codigo, nome, descricao, precoUnitario, categoria);
                produtos.add(produto);

                // Limpar campos após a inserção
                ((EditText) findViewById(R.id.editTextCodigo)).setText("");
                ((EditText) findViewById(R.id.editTextNome)).setText("");
                ((EditText) findViewById(R.id.editTextDescricao)).setText("");
                ((EditText) findViewById(R.id.editTextPrecoUnitario)).setText("");
                ((EditText) findViewById(R.id.editTextCategoria)).setText("");
            }
        });
    }
}
