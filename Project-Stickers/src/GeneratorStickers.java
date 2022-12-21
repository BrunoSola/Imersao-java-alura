import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeneratorStickers {

    private static final int STICKER_WIDTH = 300;
    private static final int TEXT_AREA_SIZE = 30;
    private static final int FONT_SIZE = 16;
    private static final int PADDING_BOTTOM = 10;

    public void cria(InputStream inputStream, String fileName, String title) throws IOException{


        BufferedImage originalImage = null;
            try{
                // Fazer a Leitura da imagem
                originalImage = ImageIO.read(inputStream);

                // Criar uma imagem em memória, com novo tamanho e transparente
                int originalResizedHeight = (originalImage.getHeight() * STICKER_WIDTH) / originalImage.getWidth();
                int height = originalResizedHeight + TEXT_AREA_SIZE;
                BufferedImage newImage = new BufferedImage(STICKER_WIDTH, height, BufferedImage.TRANSLUCENT);

                // Copiar a imagem original para a nova imagem(em memória)
                Graphics2D graphics = (Graphics2D) newImage.getGraphics();
                graphics.drawImage(originalImage, 0, 0, STICKER_WIDTH, originalResizedHeight, null);

                //Configurando fonte
                Font font = new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE);
                graphics.setFont(font);
                graphics.setColor(Color.YELLOW);

                String text = title;

                // Configurando posicionamento do texto
                FontMetrics metrics = graphics.getFontMetrics();
                float coordinateX = ((float) newImage.getWidth() / 2) - ((float) metrics.stringWidth(text) / 2);
                graphics.drawString(text, coordinateX, newImage.getHeight() - PADDING_BOTTOM);

                //Nova imagem.
                ImageIO.write(newImage, "png", new File("C:/workspace/Imersao-Java/Project-Stickers/Stickers/" + fileName));
            } catch (IIOException e) {
                System.out.println("Unsupported Image Type");
            }
            catch (NullPointerException e) {
                System.out.println("Unsupported Image Type");
            }
    }
}
