import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createTodoForUsername,
  retrieveTodoForUsername,
  updateTodoForUsername,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { ErrorMessage, Field, Form, Formik } from "formik";
import moment from "moment";

const TodoComponent = () => {
  const { id } = useParams();
  const { username } = useAuth();
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");
  const navigate = useNavigate();

  const retrieveTodo = () => {
    if (id != -1) {
      retrieveTodoForUsername(username, id)
        .then((response) => {
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
        })
        .catch((error) => console.log(error));
    }
  };

  const onSubmit = (values) => {
    const todo = {
      username: username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };

    if (id == -1) {
      createTodoForUsername(username, todo)
        .then((response) => navigate("/todos"))
        .catch((error) => console.log(error));
    } else {
      updateTodoForUsername(username, id, { ...todo, id: id })
        .then((response) => navigate("/todos"))
        .catch((error) => console.log(error));
    }
  };

  const validate = (values) => {
    const erros = {};

    if (values.description.length < 5) {
      erros.description = "Enter atleast 5 charecters";
    }

    if (
      values.targetDate.length == null ||
      values.targetDate === "" ||
      !moment(values.targetDate).isValid()
    ) {
      erros.targetDate = "Enter a target date";
    }

    return erros;
  };

  useEffect(() => {
    retrieveTodo();
  }, [id]);

  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnBlur={false}
          validateOnChange={false}
        >
          {(props) => (
            <div>
              <Form>
                <ErrorMessage
                  name="description"
                  component="div"
                  className="alert alert-warning"
                />

                <fieldset className="form-group">
                  <label for="description">Description</label>
                  <Field
                    type="text"
                    className="form-control"
                    name="description"
                  />
                </fieldset>

                <ErrorMessage
                  name="targetDate"
                  component="div"
                  className="alert alert-warning"
                />

                <fieldset className="form-group">
                  <label for="targetDate">Target Date</label>
                  <Field
                    type="date"
                    className="form-control"
                    name="targetDate"
                  />
                </fieldset>
                <div>
                  <button className="btn btn-success m-5" type="submit">
                    Save
                  </button>
                </div>
              </Form>
            </div>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default TodoComponent;
