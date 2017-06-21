package br.com.app.agenda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
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
    private final ImageView campoFoto;

    private Aluno aluno;

    public FormularioHelper(Fomulario activity)
    {
        campoNome      = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco  = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone  = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoSite      = (EditText) activity.findViewById(R.id.formulario_site);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
        campoFoto = (ImageView) activity.findViewById(R.id.foto);

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
        aluno.setCaminhofoto((String) campoFoto.getTag());
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        carregaImagem(aluno.getCaminhofoto());
        this.aluno = aluno;
    }

    public void carregaImagem(String caminhoFoto) {
        if(campoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300,300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }

    }
}
