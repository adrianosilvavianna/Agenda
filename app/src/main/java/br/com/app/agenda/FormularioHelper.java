package br.com.app.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.app.agenda.modelo.Aluno;

/**
 * Created by Adriano on 28/05/2017.
 */

public class FormularioHelper {

    private final RatingBar campoNota;
    private final EditText campoSite;
    private final EditText campoTelefone;
    private final EditText campoEndereco;
    private final EditText campoNome;
    private Aluno aluno;

    public FormularioHelper(Fomulario activity)
    {
        campoNome      = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco  = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone  = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoSite      = (EditText) activity.findViewById(R.id.formulario_site);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);

        String nome     = campoNome.getText().toString();
        String endereco = campoEndereco.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String site      = campoSite.getText().toString();

        aluno = new Aluno();
    }

    public Aluno getAluno() {

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }
}
