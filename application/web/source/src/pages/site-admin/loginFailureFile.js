const getLoginFailureFileContent = (report) => {
  let date = report;
  let dates = [];
  const count = {};

  for (let i = 0; i < date.length; i++) {
    dates[i] = date[i].split(" ", 1);
  }
  dates.forEach((element) => {
    if (element[0] !== "") {
      count[element] = count[element] ? count[element] + 1 : 1;
    }
  });
  return count;
};

export function getFileNotFoundMessage(fileContentData) {
  return fileContentData.includes("!DOCTYPE")
    ? "Sorry, I could not find that log"
    : "";
}
export default getLoginFailureFileContent;
