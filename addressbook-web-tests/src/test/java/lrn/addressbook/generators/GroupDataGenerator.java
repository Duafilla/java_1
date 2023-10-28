package lrn.addressbook.generators;

import lrn.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData> groups = generateGroups(count);
        try {
            save(groups, file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData(String.format("Test %s",i),String.format("header %s",i),String.format("footer %s",i)));
        }
        return groups;
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (GroupData group:groups) {
            writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),group.getFooter()));
        }
        writer.close();
    }
}
