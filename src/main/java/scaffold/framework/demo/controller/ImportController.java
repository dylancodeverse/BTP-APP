package scaffold.framework.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.imports.DevisImported;
import scaffold.framework.demo.models.imports.Maisontravaux;
import scaffold.framework.demo.models.imports.PaiementImported;

@Controller
public class ImportController {

    @Value("${tmp.path}")
    String path;

    @Autowired
    DataSource dataSource;

    @GetMapping("/importdonnees")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getDonnees() {
        return "pages/models/import/ImportDonnees";
    }

    @GetMapping("/importpaiement")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getPaiement() {
        return "pages/models/import/ImportPaiement";
    }

    @PostMapping("/uploaddonnees")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String submitdonnees(@RequestParam("maisonettravaux") MultipartFile maisonettravaux,
            @RequestParam("devis") MultipartFile devis, char separateur) throws Exception {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        try {
            // maisonettravaux
            // .transferTo(new File(path + System.currentTimeMillis() +
            // maisonettravaux.getOriginalFilename()));
            // devis.transferTo(new File(path + System.currentTimeMillis() +
            // devis.getOriginalFilename()));

            if (!maisonettravaux.isEmpty()) {
                try (
                        Reader reader = new BufferedReader(
                                new InputStreamReader(maisonettravaux.getInputStream()))) {
                    CsvToBean<Maisontravaux> csvToBean = new CsvToBeanBuilder<Maisontravaux>(
                            reader)
                            .withType(Maisontravaux.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator(separateur)
                            .build();
                    List<Maisontravaux> importedDataList = csvToBean.parse();
                    System.out.println(importedDataList.size());
                    Integer a = importedDataList.get(1).getDuree_travaux();
                    System.out.println(a);
                    // eto mi insert anaty base
                    Maisontravaux.insertAll(connection, importedDataList);
                    Maisontravaux.insertAllPeripherie(connection);

                } catch (Exception e) {
                    throw e;
                }
            }

            if (!devis.isEmpty()) {
                try (
                        Reader reader = new BufferedReader(
                                new InputStreamReader(devis.getInputStream()))) {
                    CsvToBean<DevisImported> csvToBean = new CsvToBeanBuilder<DevisImported>(
                            reader)
                            .withType(DevisImported.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator(separateur)
                            .build();
                    List<DevisImported> importedDataList = csvToBean.parse();
                    // eto mi insert anaty base
                    DevisImported.insertAll(connection, importedDataList);
                    DevisImported.insertAllPeripherie(connection);
                    connection.commit();
                } catch (Exception e) {
                    throw e;
                }
            }

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }
        return "pages/models/import/ImportDonnees";
    }

    @PostMapping("/uploadpaiement")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String submitpaiement(@RequestParam("paiement") MultipartFile file, char separateur) throws Exception {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        try {
            // maisonettravaux
            // .transferTo(new File(path + System.currentTimeMillis() +
            // maisonettravaux.getOriginalFilename()));
            // devis.transferTo(new File(path + System.currentTimeMillis() +
            // devis.getOriginalFilename()));

            if (!file.isEmpty()) {
                try (
                        Reader reader = new BufferedReader(
                                new InputStreamReader(file.getInputStream()))) {
                    CsvToBean<PaiementImported> csvToBean = new CsvToBeanBuilder<PaiementImported>(
                            reader)
                            .withType(PaiementImported.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator(separateur)
                            .build();
                    List<PaiementImported> importedDataList = csvToBean.parse();
                    // eto mi insert anaty base
                    PaiementImported.insertAll(connection, importedDataList);
                    PaiementImported.insertAllPeripherie(connection);
                    connection.commit();
                } catch (Exception e) {
                    throw e;
                }
            }

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }

        return "pages/models/import/ImportPaiement";
    }

}
