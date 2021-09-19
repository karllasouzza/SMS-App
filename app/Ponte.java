public class Ponte {
        Context contexto;

        public Ponte(Context contexto) {
            this.contexto = contexto;
        }

        @JavascriptInterface
        public void enviaSms(String numero, String mensagem) {
            try {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(numero, null, mensagem, null, null);
                Toast.makeText(this.contexto, "SMS Enviado", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this.contexto, "Erro no Envio:"+ex.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }