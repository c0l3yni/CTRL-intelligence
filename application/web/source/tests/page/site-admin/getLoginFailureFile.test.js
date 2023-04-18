import getLoginFailureFileContent from "../../../src/pages/site-admin/loginFailureFile";

test("get login failure dates and count of failures", () => {
  let dates = [
    "2022-10-09 0908 helloKitty Incorrect username",
    "2022-11-01 1042 RonaldRegan Invalid Password",
    "2022-11-01 1142 Yoda Incorrect input",
  ];
  expect(getLoginFailureFileContent(dates)).toStrictEqual({
    "2022-10-09": 1,
    "2022-11-01": 2,
  });
});
