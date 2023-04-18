const fs = require("fs");

const folderPath =
  "../application/web/test/build/reports/coverage/requirements";

function getFilesInDirectory(folderPath) {
  return fs.readdirSync(folderPath, (err, files) => {
    return files;
  });
}

function readFile(file) {
  const rawData = fs.readFileSync(`${folderPath}/${file}`);
  const parsedData = JSON.parse(rawData);
  return parsedData;
}

function generateReport() {
  const files = getFilesInDirectory(folderPath);
  const report = {
    coverage: "requirements",
    requirements: [],
  };

  files.forEach((file) => {
    let requirements = readFile(file).requirements;
    if (requirements != null || requirements != undefined) {
      requirements.forEach((requirement) => {
        report.requirements.push(requirement);
      });
    }
  });

  return report;
}

function createReportFile(report) {
  fs.writeFile(
    "Full-Requirements-Report.rpt",
    JSON.stringify(report),
    (err) => {
      if (err) throw err;
      console.log("Report Created Successfully!");
      console.log(
        "Report Path: ctrl-intelligence/requirements-report-generator/Full-Requirements-Report.rpt"
      );
    }
  );
}

createReportFile(generateReport());
