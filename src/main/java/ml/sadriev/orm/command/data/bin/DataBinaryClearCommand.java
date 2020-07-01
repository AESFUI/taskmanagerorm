package ml.sadriev.orm.command.data.bin;

import java.io.File;
import java.nio.file.Files;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.constant.DataConstant;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataBinaryClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "Remove binary data.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
    }
}
